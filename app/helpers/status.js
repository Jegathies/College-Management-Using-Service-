import Ember from 'ember';

export function status(value) {
  if(value=="pending")
  return true;
}

export default Ember.Helper.helper(status);
