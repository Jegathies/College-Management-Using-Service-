import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL,
  
});

Router.map(function() {
  this.route('login');
  this.route('registration');
  this.route('student', function() {
    this.route('addStudent');
    this.route('viewStudent');
    this.route('pendingStudentList');
  });
  this.route('department', function() {
    this.route('addDepartment');
    this.route('viewDepartment');
  });
  this.route('staff', function() {
    this.route('addStaff');
    this.route('viewStaff');
  });
  this.route('getStudentDetail',{path:'getStudentDetail/:getStudentDetail_id'});
});

export default Router;
