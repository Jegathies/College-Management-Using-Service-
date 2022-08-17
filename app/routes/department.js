import Ember from 'ember';
import RSVP  from 'rsvp';
export default Ember.Route.extend({
    beforeModel() {
        let s=this;
        Ember.$.ajax({
            // credentials: true, origin: 'http://localhost:4200',
            xhrFields: {
                withCredentials: true
             },
            type:'post',
            error: function(err, response) {console.log(response)},
            url:"http://localhost:8081/college/SessionStatus",
            success:function(response)
            {
                alert(response);
                if(response!="exists")
                {
                    
                    s.transitionTo('login');
                }
                
            }});
        },

        // if(sessionStorage.getItem("auth") != "positive") {
        //     s.transitionTo('login');
        // }

        // }
    logged: Ember.inject.service(),
   
    model()
    {
    return RSVP.hash({
         role:this.get('logged').role,
    });
    }   
});
