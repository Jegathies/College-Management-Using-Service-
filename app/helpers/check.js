import Ember from 'ember';

export function check(value) {
  if(value=="admin")
  {
    return true;
  }
 
}

export default Ember.Helper.helper(check);
