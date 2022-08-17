import Ember from 'ember';
import RSVP from 'rsvp';
export default Ember.Route.extend({
    logged: Ember.inject.service(),
    model()
    {
       
        let data = {
            clg_id: this.get('logged').clg_id,
            status:"approved"
        };
        return RSVP.hash({
            
            studentModel:
                Ember.$.ajax({
                type: "GET",
                url: "http://localhost:8081/college/ViewStudent",
                // data: {
                //     email:"sri@gmail.com",
                //     status:"approved"
                    
                // },
                data:data,
                success:function(response) 
                {
                   return response;
                }}),
            departModel: 
            
                Ember.$.ajax({
                    type: "GET",
                    url: "http://localhost:8081/college/getDepartment",
                    // data: {
                    //     email:"sri@gmail.com",
                    //     status:"approved"
                        
                    // },
                    data:data,
                    success:function(response) {
                       return response
                    },
                  }),
            
            
    });
}
});
