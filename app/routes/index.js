import Ember from 'ember';

import RSVP  from 'rsvp';
export default Ember.Route.extend({
    logged: Ember.inject.service(),
    // beforeModel() {
    //     this._super(controller, model);
    //      if(this.get("logged").role==null)
    //      {
    //         this.transitionTo('login');
    //      }
    // },
    beforeModel() {
        let s=this;
        Ember.$.ajax({
            // credentials: true, origin: 'http://localhost:4200',
            type:'post',
            xhrFields: {
                withCredentials: true
             },
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
    model()
    {
    return RSVP.hash({
         role:this.get('logged').role,
    });
    }  
});
