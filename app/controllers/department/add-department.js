import Ember from 'ember';

export default Ember.Controller.extend({
    logged:Ember.inject.service(),
    result:null,
    actions: {
        addDep(department)
        {
            
            let s=this;
            if(department!="")
            {
                
                Ember.$.ajax({
                type:'get',
                url:"http://localhost:8081/college/addDepartment",
                data:{
                    id:s.get('logged').id,
                    department:department,
                },
                success:function(response)
                {
                    if(response=="added")
                    {
                        alert("Added Successfully");
                    }
                    else{
                        alert("Sorry!!! Try sometimes later ");
                    }
                    document.getElementById("depName").value="";
                }

                })
            }
            else
            {
                alert("please enter department name");
            }
            
        }
    }
});
