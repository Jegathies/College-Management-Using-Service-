import Ember from 'ember';

export default Ember.Route.extend({
    logged:Ember.inject.service(),
    model(params)
    {
    //     return $.getJSON('http://localhost:8081/college/ViewStudent?email=sri@gmail.com&status=approved').then(function(result) {
           
    //         let ele =  result.filter(function(item, index) {
              
    //           return item.email=== params.getStudentDetail_id
    //         });
    //         console.log(ele);
    //         return ele;
    //     });
    // } 
        
        let data = {
            id: params.getStudentDetail_id,
        };
        return Ember.$.ajax({
            type: "GET",
            url: "http://localhost:8081/college/getStudentDetail",
            data:data,
            success:function(result) 
            {
                return result;
            }})
    }
    

    // model(params)
    // {
    //    return $.getJSON('https://fakestoreapi.com/products').then(function(result) {
    //         let ele =  result.filter(function(item, index) {
    //           return item.id == params.cart_id;
    //         });
    //         return ele[0];
    //         //resolve(result);
    // });
    //  }
});
