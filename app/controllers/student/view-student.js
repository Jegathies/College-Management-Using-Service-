import Ember from 'ember';

export default Ember.Controller.extend({
    logged:Ember.inject.service(),
    actions: {
        getValueOnClick()
        {
            
            let model=this.get("model.studentModel");
            let department=(document.getElementById("depart").value);
            let year=(document.getElementById("year").value);

            if(department!="1"&&year!="1")
            {
                let filterbyYear=model.filterBy('yearOfJoining',year);
                let depart=filterbyYear.filterBy('department',department );
                
                this.set("hasDep",true);
                this.set("sortByDepartment",depart);
                if(depart.length==0)
                {
                    alert("Sorry!!! No Student joined yet")
                }
            }
            else if(department!="1"&&year=="1")
            {
                let depart=model.filterBy('department',department );
                this.set("hasDep",true);
                this.set("sortByDepartment",depart);
                if(depart.length==0)
                {
                    alert("Sorry!!! No Student joined yet");
                }
            }
            else if(department=="1"&&year!="1"){

                
                let filterbyYear=model.filterBy('yearOfJoining',year);
                this.set("hasDep",true);
                this.set("sortByDepartment",filterbyYear);

                console.log(typeof(depart));
                if(filterbyYear.length==0)
                {
                    alert("Sorry!!! No Student joined yet")
                }
            }
            else{
                
                this.set("hasDep",false);
                this.set("sortByDepartment",null);
            }   
        }
        // getSortedValue()
        // {
        //     this.toggleProperty('Sorted');
        //     if(this.hasDep)
        //     {
        //         let arrayToSort = this.get("sortByDepartment");
        //         console.log(arrayToSort);
        //         if(arrayToSort.length>0)
        //         {
        //             for(let i=0;i<arrayToSort.length;i++)
        //             {
        //                 for(let j=0;j<arrayToSort.length;j++)
        //                 {
        //                     if(arrayToSort[i].name<arrayToSort[j].name)
        //                     {
        //                         let temp=arrayToSort[i];
        //                         arrayToSort[i]=arrayToSort[j];
        //                         arrayToSort[j]=temp;
        //                     }
        //                 }
        //             }
        //         }
        //         this.set("sortByDepartment",arrayToSort);
        //     }
        //     else{
        //         let arrayToSort = this.get("model.studentModel");
        //         console.log(arrayToSort);
        //         for(let i=0;i<arrayToSort.length;i++)
        //         {
        //             for(let j=0;j<arrayToSort.length;j++)
        //             {
        //                 if(arrayToSort[i].name<arrayToSort[j].name)
        //                 {
        //                     let temp=arrayToSort[i];
        //                     arrayToSort[i]=arrayToSort[j];
        //                     arrayToSort[j]=temp;
        //                 }
        //             }
        //         }
        //         this.set("model.studentModel",arrayToSort);
        //         console.log(arrayToSort);
                
        //     }
        // }, 
        ,
        blur()
        {
            
            let blur_background=document.getElementById("blur").classList;
            blur_background.toggle("bluring");
            console.log(blur_background)
            
        }


    }
});
