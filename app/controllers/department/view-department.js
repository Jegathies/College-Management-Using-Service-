import Ember from 'ember';

export default Ember.Controller.extend({
    logged:Ember.inject.service(),
    result:null,
    values:false,
    actions: {
        notify() {  
            let s=this;
            Ember.$.ajax({
                type: "GET",
                url: "http://localhost:8081/college/ViewDepartment",
                data:{
                    clg_id:s.get('logged').clg_id,
                },
                success:function(response) {
                    s.set("result",response);
                    s.toggleProperty('values');
                    if(s.values)
                    {
                        document.getElementById("toggleButton").value="Get Department";
                    }
                    else{
                        document.getElementById("toggleButton").value="Get Number of Students in Department";
                    }
                },
              });
            }
    }
});
