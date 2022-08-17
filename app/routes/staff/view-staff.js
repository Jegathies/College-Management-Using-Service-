import Ember from 'ember';
import RSVP from 'rsvp';
export default Ember.Route.extend({
    logged: Ember.inject.service(),
    model()
    {
       
        let data = {
            clg_id: this.get('logged').clg_id,
        };
        return RSVP.hash({
            
            staffModel:
                Ember.$.ajax({
                type: "GET",
                url: "http://localhost:8081/college/ViewStaff",
                data: data,
                success:function(response) 
                {
                   return response;
                }}),
                
            departModel: 
            
                Ember.$.ajax({
                    type: "GET",
                    url: "http://localhost:8081/college/getDepartment",
                    data:data,
                    success:function(response) {
                       return response
                    },
                  }),
            
    });
}
});
