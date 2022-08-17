import Ember from 'ember';

export default Ember.Controller.extend({
    logged:Ember.inject.service(),
    actions: {
        getValue()
        {
            let model=this.get("model.studentModel");
            let department=(document.getElementById("depart").value);
            let depart=model.filterBy('department',department );
            if(department=="1")
            {
                this.set("hasDep",false);
                this.set("sortByDepartment",null);
            }
            else if(depart==null){
                this.set("hasDep",true);
                this.set("sortByDepartment",null);
                alert("No Student available");
            }
            else{
                this.set("hasDep",true);
                this.set("sortByDepartment",depart);
            }
        },
        blur()
        {
            
            let blur_background=document.getElementById("blur").classList;
            blur_background.toggle("bluring");
            console.log(blur_background)
            
        },


    }
});
