import Ember from 'ember';

export default Ember.Route.extend({
    logged: Ember.inject.service(),
    model()
    {
        console.log(this.get('logged').clg_id);
        let data = {
            clg_id: this.get('logged').clg_id, 
        };
        return Ember.$.ajax({
            type: "GET",
            url: "http://localhost:8081/college/getDepartment",
            data: data,
            success:function(response) {
                return response;
            }
          });
    }
});


