This project involved creating an inventory system for a hypothetical product shop which allows end users to update their inventory counts for outsourced and inhouse parts. 

CHANGES

1.) Created a work-branch to start off the project. 
2.) Deleted default README.MD file that came with the project. Created this new one to include all changes. Commited the new file 

PART C:Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

1. Edited the shop name in mainscreen.html
 - Line 14: Changed site title to The Sandwich Shop
 - Line 19: Changed H1 tag to "The Sandwich Shop"
 - Used git add . to stage changes
 - Used git commit -m to add a commit message detailing the above changes along with adding the 5 parts and products detailed below

2. Included the product and parts name that were hardcoded into the BootStrapData.java file

- Line 34: Added the InhousePartRepository object in the BootStrapData class
- Line 38 + Line 42: Added the InhousePartRepository argument and assigned/initialized it to the attribute that was added above
- Line 70 - 73: Created an Inhouse lettuce part. Set the name, price and inventory
- Line 75-78: Created an Inhouse cheese part. Set the name, price and inventory
- Line 80-83: Created the Inhouse mayo part. Set the name, price and inventory
- Line 85-88: Created the outsourced salami part. Set the name, price and inventory
- Line 90-93: Created the outsourced pastrami part. Set the name, price and inventory
- Line 95-99: Saved all of the above mentioned parts to their respective repositories. The inhouse parts went to the inhousePartRepository and the 
outsourced parts when to the outsourcedPartRepository

-Line 102 - 106: Created 5 products, salamiSandwhich, pastramiSandwhich, bolognaSandwhich, turkeySandwhich and chickenSandwhich. Added the names of each as well as 
the price and inventory count. 
-Line 108 - 112: Added all of the above created products to the productRepository using the save method. 


PART D: Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

 Created an about.html file in the templates folder found in src/main/resources/templates
 -Line 1 - 15: Added boilerplate HTML code including the !DOCTYPE html, <head> and <body> tags
 -Line 10: Added a link using a href= "/mainscreen" that links back to the mainscreen
 -Line 12: Added a <p> tag with some text introducing the sandiwch shop and telling the customer to customize any sandwich
 
 Modified the mainscreen.html file to include the link to the newly created about.html
 - Line 23: Created a link using a href="/about" that links to the new about page right under the Sandwich Shop H1

Created an AboutController.java file that will use GetMapping to display the actual content that found in the about.html. This is found in src/main/java/controllers
 -Line 1: import the controller package
 -Line 2-3: import Controller and GetMapping
 -Line 5: Designate it as a Controller object
 -Line 8 - 11: Designate it as a GetMapping object so that Spring can relay the information upon request. The method is called showAboutPage() and it 
returns the about.html view created above

Added all changes to online repository
 -Used git add . to stage commits
 -Used git commit -m to add a description about the commit detailing the addition of the about page as well as the links and changes to the README
 -Used git push on the top taskbar of Intellij to commit the changes

PART E: Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

Since I added the sample inventory above in Part C, I reconfigured the code so that the parts are placed into a HashSet object. I then added the parts to the set
and invoked the product.setParts method with the newly created Set as a parameter so that no duplicate parts can be associated with each product. I also added an 
IF clause that checked to see if the part and product repositories had data already. 

Here are the changes made in BootStrapData.java:

-Lines 19 - 22: Imported Hashset, List and Set
-Line 50 - 52: If clause that checks if the repositories contain data. If it doesn't, all of the code to create the sample inventory will be run
-Line 76 - 99: Initialized Inhouse and Outsourced part objects and set the name, price and inventory count
-Line 101 - 105: Saved each newly created part to their respecting repositories(Inhouse, outsourced)
-Line 108: Created a set called parts
-Line 110 - 114: Added all 5 parts to the set
-Line 116 - 134: Initializes 5 products with name, price and inventory counts. Runs the Product setParts method and puts the set created above as a parameter. 
Then ran the save function to add to the product repository. 
-Line 138: Included a System.out to print if the sample inventory has been added
-Line 139 - 141: If it has not been added, print out that an inventory already exists

Updated the README file to include PART E

Added all changes to online repository
 -Used git add . to stage commits
 -Used git commit -m to add a description about the commit detailing the addition of the about page as well as the links and changes to the README
 -Used git push on the top taskbar of Intellij to commit the changes

PART F: Add a “Buy Now” button to your product list

The “Buy Now” button must be next to the buttons that update and delete products:
In mainscreen.html: 
 -Line 91-93: Created a thymeleaf post action Buy Now button and placed it in the table row with the update and delete button for products

In BuyProductController.java:
-Created the controller to handle the post request from mainscreen
-Lines 1-9: imported dependencies including the java Optional object in line 9
-Line 23: Created the buyProduct function that takes two arguments. One is the product ID and the second is the model object
-Line 24: Uses Optional to retrieve a product from the repository using the ProductId
-Line 26: Checks to see if the object is present given the product Id
-Line 27 - 32: If it IS present, assign its inventory to currentInventory. It then checks to see if the inventory is greater than zero and if it is it will 
decrement it by 1. The product is then saved to the repository and the user is redirected to the purchaseResult page to show a successful purchase message
-Line 34 - 35 Redirect to the purchaseFailed page in case the inventory is 0 and the user clicks buy now. 
-Line 37: Defaulted to return the mainscreen 

In purchaseresult.html:
-Line 1 - 11: DOCTYPE boilerplate added
-Line 8: <p> tag saying the purchase went through
-Line 9: Added a link back to the mainscreen.html

In purchaseFailed.html:
-Line 1-11: DOCTYPE boilerplate added
-Line 8: <p> tag saying the purchase failed
-Line 9: Added a link back to the mainscreen.html

Push Changes to Online Repository:
-Git add .
-Git commit -m "Message describing above changes added"
Git > Push on Intellij taskbar

G.Modify the parts to track maximum and minimum inventory

In Part.java:


Modify the code to enforce that the inventory is between or at the minimum and maximum value:

Line 32+33: Added minInv and maxInv variables
Line 84 - 92: Updated setInv method to check whether inv count is between minInv and maxInv. If not, throw an exception.
Line 94 - 106: Getter and setter methods for both minInv and maxInv

In OutsourcedPart.java

- Line 29 - 41: Getter and setter methods for both minInv and maxInv

In InhousePart.java

- Line 28-40: Getter and setter methods for both minInv and maxInv

In mainscreen.html

- Line 42+43: Added table header for minInv and maxInv
- 52 + 53: Added values to the table for minInv and maxInv

In InhousePartForm.html

-Line 30 + 32: Added input form fields for minInv and maxInv

In OutsourcedPartForm.html

-Line 28 + 30: Added input form fields for minInv and maxInv

Rename the file the persistent storage is saved to

In application.properties
-Line 6: Edited the filename to my-spring-boot-h2-db102
-Used file explorer on my system to find the original URL and renamed it to my-spring-boot-h2-db102


At this point in the project, I decided to create an import.sql file to add the sample inventory to the database instead of declaring each
one in the BootStrapJava file. This allowed me to set default values for minimum and maximum inventory as well as 
handle duplicate parts to create multi-pack parts

In the BootStrapData file: 
Deleted all instantiations of parts and products since they were added in the import.sql file
Line 43: Kept the IF clause to check whether repositories had inventory
All other lines remained the same

In the import.sql file:
Line 2 - 20: Used Insert INTO statement to add each part with default values. Inhouse parts had a type of 1 and outsourced parts had a type of 2. 
Line 4, 8, 12, 16, 20: ON DUPLICATE statement to add the inventory value for any duplicate parts added
Line 24 - 29: Used Insert INTO statement to add sample products and values
Line 33 - 38: Inserted/Associated every product with all 5 parts

PART H Add validation for between or at the maximum and minimum fields

To add validation for minimum and maximum inventory counts:

In the validators folder, I created a InventoryRangeValidator file and a ValidInventoryRange annotation file

In InventoryRangeValidator:
-Line 1-5: Imported ConstraintValidator, Part class, and ConstraintValidatorContext
-Line 8: Declare InventoryRangeValidator class which implements the ConstraintValidatorContext
-Line 11 - 16: boolean isValid class to set temp variables for inventory, minInv and maxInv. Return true if inventory is greater than or equal to minInv and less
than or equal to maxInv

In ValidInventoryRange:
-Line 1-4: Imported Constraint, Payload and annotation
-Line 6-9:Added @Document, @Constraint, @Target and @Retention - Runtime
-Line 10 - 13: Declared ValidInventoryRange and set default error message

In Part.java:

-Line 4: Imported newly created validator ValidInventoryRange
-Line 24: Added @ValidInventoryRange annotation

In inhousePartForm.html:
-Line 20-22: Added if clause to handle outputting red text error message if the field encounters an error

In outsourcedPartForm.html:
Line 22-24: Added if clause to handle outputting red text error message if the field encounters an error

To add validation for products in the case where adding or updating products lowers the part inventory below the minimum

In the validators folder I created a class called ProductInventoryValidator and an annotation called ValidProductInventory

In ProductInventoryValidator:
-Line 1-4: Imported ConstraintValidator, ConstraintValidatorContext, Part and Product class
-Line 7: Declared ProductInventoryValidator which implements ConstraintValidator
-Line 10-20: boolean isValid that takes a part object as parameter and accepts null objects to return true. 
-Line 17: declare partMinInv to grab the minInv value
-Line 18: declare a product's inv value
-Line 19 - 20: Loop through and make sure that the product's inventory doesn't ever get below the part's minInv

In Part.java:
-Line 5: Imported ValidProductInventory
-Line 25: Added ValidProductInventory annotation

Updated README file to include above changes for Part H

Pushed changes to Gitlab:
git add .
git commit -m "Added validators and annotations to enforce the minInv and maxInv attributes for parts and products"
git push > work-branch

Pushed README file update to Gitlab
git add .
git commit -m "Updated README file"
git push 

PART I: Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package

In PartTest class:

-Line 10: Imported assertThrows
-Line 107 - 109: Created a test to check whether the illegal arg exception is thrown for minInv - 1 for inhouse part
-Line 111 - 113: Created a test to check whether the illegal arg exception is thrown for maxInv + 1 for inhouse part
-Line 117 - 119: Created a test to check whether the illegal arg exception is thrown for minInv - 1 for outsourced part
-Line 121 - 123: Created a test to check whether the illegal arg exception is thrown for maxInv + 1 for outsourced part

Part J: Remove the class files for any unused validators in order to clean your code

Removed unused import class statements in the following files:
        AddInhousePartController.java
        AddOutsourcedPartController.java
        AddPartController.java
        MainScreenControllerr.java
        PartRepository.java
        InhousePartService.java
        InhousePartServiceImpl.java
        OutsourcedPartService.java
        PartService.java
        PartServiceImpl.java
        ProductService.java
        ProductServiceImpl.java
        DeletePartValidator.java
        PriceProductValidator.java
        PartTest.java

The only validator that had no usages was the DeletePartValidator which is because it only comes into play when 
a user tries to delete a part that is already associated with a product. Therefore, it is still an essential part of the codebase. 

Pushed all changes to Gitlab including the README file changes

git add .
git commit -m "Added 4 Unit tests for minimum and maximum inventory values. Cleaned up code for unused import statements"
git push > work-branch

AFTER 1st SUBMISSION

Submission was rejected because the sample parts and products were not showing up. I deleted the import.sql file and instead went back to
instantiating each part and object in the BootStrapData.java file 

In BootStrapData.java:
-Line 45 - 49: Created 3 new Inhouse parts (lettuce, cheese and mayo). Created 2 Outsourced Parts (salami and pastrami)
-Line 51-55: Saved each newly created parts to the part repository
-Line 57-61: Created 5 products (salami sandwich, pastrami sandwich, bologna sandwich, turkey sandwich and chicken sandwich)
-Line 63-67: Saved each product to the product repository

In OutsourcedPart domain file:
-Line 21 - 28: Added constructor function with the parameters from above to also include minInv and maxInv

In InhousePart domain file:
-Line 20-26: Added constructor function witht he parameters from above to also include minInv and maxInv

Push changes to online repository

git add .
git commit -m "Deleted import.sql file and added sample parts and products to bootstrapdata file. Updated constructor functions in both inhousepart and outsourcedpart classes"
git push > work-branch
