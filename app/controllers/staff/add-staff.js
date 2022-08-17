import Ember from 'ember';

export default Ember.Controller.extend({
    logged:Ember.inject.service(),
    result:null,
    validateName()
    {
      let name=this.get("name");
      
        var regex = /^[a-zA-Z ]{2,30}$/;
        if(regex.test(name)) 
        {
          console.log(name);
          return true;
        }
        else{
          alert("Enter a valid Name");
        }
        return false;
      
    },
    validateEmail()
    {
      let email=this.get("email");
      
        var regex = /^[\w-\.]+@([\w]+\.)+[\w-]{2,4}$/;
        if(regex.test(email)) 
        {
          console.log(email);
          return true;
        }
        else{
          alert("Enter a valid Email");
        }
        return false;
      
    },
    actions: {
        addStaff() {  
            let name=this.get("name");
            this.set("department",document.getElementById("depart").value);
            console.log(this.department);
            let password=this.get("password");
            let email=this.get("email");
            let clg_id=this.get("logged").clg_id;

            let s=this;
            if(this.validateName())
                {
                  if(this.validateEmail())
                  {
                  Ember.$.ajax({
                    type: "post",
                    url: "http://localhost:8081/college/addStaff",
                    data: {
                      name:name,
                      department:s.department,
                      password:password,
                      email:email,
                      clg_id:clg_id
                    },success:function() {
                        alert("success");
                        document.getElementById("staffForm").reset();
                    },
                  });   
                  
                } 
              }
            } 

    }
});
