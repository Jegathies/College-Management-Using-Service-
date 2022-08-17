import Ember from 'ember';
import RSVP  from 'rsvp';
export default Ember.Route.extend({
    logged: Ember.inject.service(),
    model()
    {
    return RSVP.hash({
         role:this.get('logged').role,
    });
    }   
});
