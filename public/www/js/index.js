$( document ).ready(function(){
    var $newTaskInput = $('#newTaskInput');
    var $taskList = $('#taskList');
    var taskTouchStart;
    var taskTouchEnd;
    var taskTouchStartX;
    var taskTouchEndX;
    var taskList = new Array();
    if(window.localStorage){
        taskList = JSON.parse(window.localStorage.getItem('taskList'));
    }
    if(null !== taskList){
        for(i=0;i<taskList.length;i++){
            var done = taskList[i].done ? 'done' : '';
            var newTask = '<li data-key="' + taskList[i].key + '" class="'+ done +'"><span>' + taskList[i].task+ '</span></li>'
            $taskList.append(newTask);
        }
    }
    else {
        taskList = new Array();
    }
    $('#addNewTask').on('click', function(){
        if($newTaskInput.val()!==''){
            var key = Date.now();
            $taskList.append('<li data-key="'+ key +'"><span>'+ $newTaskInput.val() +'</span></li>');
            taskList.push({key:key,task:$newTaskInput.val(),done:false});
            if(window.localStorage){
                window.localStorage.setItem('taskList',JSON.stringify(taskList));
            }
            $newTaskInput.val('');
        }
    });
    $taskList.on('touchstart','li',function(e){
        var start = document.elementFromPoint(e.originalEvent.touches[0].pageX, e.originalEvent.touches[0].pageY);
        taskTouchStart = $(start).attr('data-key');
        taskTouchStartX = e.originalEvent.touches[0].pageX;
    });
    $taskList.on('touchmove','li',function(e){
        var $end;
        var $this = $(this);
        var end = document.elementFromPoint(e.originalEvent.touches[0].pageX, e.originalEvent.touches[0].pageY);
        $end = $(end);
        taskTouchEnd = $end.attr('data-key');
        taskTouchEndX = e.originalEvent.touches[0].pageX;
        if(taskTouchStart == taskTouchEnd){
            if(taskTouchStartX < taskTouchEndX){
                if($this.hasClass('done')){
                    $this.removeClass('done');
                    for(j=0;j<taskList.length;j++){
                        if(taskList[j]['key'] == $this.attr('data-key')){
                            taskList[j]['done'] = false;
                        }
                    }
                    if(window.localStorage){
                        window.localStorage.setItem('taskList',JSON.stringify(taskList));
                    }
                }
                else{
                    $this.addClass('done');
                    for(j=0;j<taskList.length;j++){
                        if(taskList[j]['key'] == $this.attr('data-key')){
                            taskList[j]['done'] = true;
                        }
                    }
                    if(window.localStorage){
                        window.localStorage.setItem('taskList',JSON.stringify(taskList));
                    }
                }
            }
            else {
                taskList = $.grep(taskList,function(e){
                   return e.key != taskTouchEnd;
                });
                if(window.localStorage){
                    window.localStorage.setItem('taskList',JSON.stringify(taskList));
                }
                $end.remove();
            }
        }
    });
});