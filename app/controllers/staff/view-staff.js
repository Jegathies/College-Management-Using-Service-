import Ember from 'ember';

export default Ember.Controller.extend({
    logged:Ember.inject.service(),
    actions: {
        getValue()
        {
            let model=this.get("model.staffModel");
            let department=(document.getElementById("depart").value);
            let depart=model.filterBy('deparment',department );
            console.log(model);
            if(department=="1")
            {
                this.set("hasDep",false);
                this.set("sortByDepartment",null);
            }
            else if(depart==null){
                alert("No Student available");
                this.set("hasDep",true);
                this.set("sortByDepartment",null); 
            }
            else{
                this.set("hasDep",true);
                this.set("sortByDepartment",depart);
            }
        }
    }
});
