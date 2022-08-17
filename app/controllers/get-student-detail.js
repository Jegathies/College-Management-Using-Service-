import Ember from 'ember';

export default Ember.Controller.extend({
    actions: {
        click_div()
        {
            this.transitionToRoute('student.viewStudent');
        }
    }
});
