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
    validatePincode()
    {
      let pincode=this.get("pincode");
      
        var regex = /^\d{6}$/;
        if(regex.test(pincode)) 
        {
          console.log(pincode);
          return true;
        }
        else{
          alert("Enter a valid pincode");
        }
        return false;
      
    },
    validateMobile()
    {
      let mobile=this.get("mobile");
      
        var regex = /^\d{10}$/;
        if(regex.test(mobile)) 
        {
          console.log(mobile);
          return true;
        }
        else{
          alert("Enter a valid Mobile Number");
        }
        return false;
      
    },
    actions: {
        addStudent() {  
            let Self=this;
            let name=this.get("name");
          //  let gender = Ember.$("gender :selected").text()
            this.set("gender",document.getElementById("gender").value);
            console.log(this.gender);
            let age=this.get("age");
            let year=this.get("year");
            //let department =Ember. $("depart:selected").text()//
            this.set("department",document.getElementById("depart").value);
            console.log(this.department);
            let address=this.get("address");
            let pincode=this.get("pincode");
            let mobile=this.get("mobile");
            let email=this.get("email");
            let clg_id=this.get("logged").clg_id;
            let status="";
            if(this.get("logged").role=="admin")
            {
              status="approved";
            }
            else{
              status="pending";
            }
            let s=this;
            if(this.validateName())
            {
              if(this.validatePincode())
              {
                if(this.validateMobile())
                {
                  if(this.validateEmail())
                  {
                  Ember.$.ajax({
                    type: "post",
                    url: "http://localhost:8081/college/AddStudent",
                    data: {
                      name:name,
                      gender:s.gender,
                      age:age,
                      department:s.department,
                      address:address,
                      pincode:pincode,
                      mobile:mobile,
                      email:email,
                      clg_id:clg_id,
                      status:status,
                      year:year
                    },success:function() {
                        if(Self.get("logged").role=="admin")
                        {
                          alert("added");
                        }
                        else{
                          alert("Request Added to Admin"); 
                        }
                        document.getElementById("studentForm").reset();
                    },
                  });  
                }
              }
            }
          } 
                  
                }  

    }
});
