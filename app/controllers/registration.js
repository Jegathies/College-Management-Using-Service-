import Ember from 'ember';

export default Ember.Controller.extend({

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
        sendRequest() {  
    if(this.validateName())
    {
      if(this.validatePincode())
      {
        if(this.validateMobile())
        {
          if(this.validateEmail())
          {
            let name=this.get("name");
            let password = this.get("password");
            let email=this.get("email");
            let address=this.get("address");
            let pincode=this.get("pincode");
            let mobile=this.get("mobile");
          Ember.$.ajax({
            type: "post",
            url: "http://localhost:8081/college/Registration",
            data: {
              name:name,
              password:password,
              email:email,
              mobile:mobile,
              address:address,
              pincode:pincode,
              role:"admin",
            },success:function() {
                alert("Regisered successfully");
                document.getElementById("form2").reset();
            },
          });   
        }
      }
    }
      }
        }   
     }
});
