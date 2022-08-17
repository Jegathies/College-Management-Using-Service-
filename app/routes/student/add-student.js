import Ember from 'ember';

export default Ember.Route.extend({
    logged:Ember.inject.service(),
    model()
    {
       return  Ember.$.ajax({
            type: "GET",
            url: "http://localhost:8081/college/getDepartment",
            data:{
                clg_id:this.get('logged').clg_id,
            },
            success:function(response) {
               return response
            },
          });
    }
});
