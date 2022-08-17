import Ember from 'ember';

export default Ember.Controller.extend({
    result:null,
    logged:Ember.inject.service(),
    actions :
    {
        sendRequest()
        {
        let s=this;
        let email=this.get("email");
        let password=this.get("password");
        Ember.$.ajax({
            type:'post',
            xhrFields: {
                withCredentials: true
             },
            url:"http://localhost:8081/college/login",
            data:{
                email:email,
                password:password,
            },
            success:function(response)
            {
                let result=response;

                if (result[0].value=="nothing")
                {

                    alert("invalid email or password");
                    document.getElementById("loginForm").reset();
                }
                else{
                    
                    s.get("logged").set("id",result[0].id);
                    // console.log(s.get("logged").id);
                    s.get("logged").set("role",result[1].role);
                    // console.log(s.get("logged").role);
                    
                    if(result[2].clg_id==undefined)
                    {
                        s.get("logged").set("clg_id",result[0].id);
                    }
                    else
                    {
                        s.get("logged").set("clg_id",result[2].clg_id);
                    }
                    document.getElementById("loginForm").reset();
                    s.transitionToRoute('index');
                    
                }
            }
        })
        }
    }
});
