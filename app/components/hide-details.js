import Ember from 'ember';

export default Ember.Component.extend({
        show:false,
        deleteComp:true,
        // observer: Ember.observer('show', function() {
        //     this.sendAction();
        // }),
        actions: {
            click_comp()
            {
                
                this.toggleProperty("show");
                let blur=document.getElementById("blur").classList;
                 blur.toggle("bluring");
                 blur.add('preventAction');
                 var element = document.getElementsByClassName('row');
                 for(var i = 0; i < element.length; i++)
                 {
                     element[i].classList.add('bluring');
                     element[i].classList.add('preventAction');
                 }


            }, 
            click_div()
            {
                this.toggleProperty("show");
                let blur=document.getElementById("blur").classList;
                 blur.toggle("bluring");
                 blur.remove('preventAction');

                 var element = document.getElementsByClassName('row');
                 for(var i = 0; i < element.length; i++)
                 {
                     element[i].classList.remove('bluring');
                     element[i].classList.remove('preventAction');
                 }
                
            } ,
            approveStudent()
            {
                let s=this;
                let id=this.get('result').id;
                Ember.$.ajax({
                    type: "get",
                    url: "http://localhost:8081/college/ApproveStudent",
                    data: {
                      status:"approved",
                      id:id,
                    },
                    success:function() {
                        alert("Approved Successfully");
                        s.toggleProperty("show");
                        s.toggleProperty("deleteComp");
                        s.set('deleteComp',false);
                        let blur=document.getElementById("blur").classList;
                        blur.toggle("bluring");
                        blur.remove('preventAction');

                        var element = document.getElementsByClassName('row');
                        for(var i = 0; i < element.length; i++)
                        {
                            element[i].classList.remove('bluring');
                            element[i].classList.remove('preventAction');
                        }   
                    },
                  });   
            }
        }
});
