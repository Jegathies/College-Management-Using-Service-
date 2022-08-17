import Ember from 'ember';

export default Ember.Route.extend({
   model()
   {
    let parent=this.modelFor('department');
    console.log(parent);
   }
});
