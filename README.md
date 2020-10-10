# Depth of Field Calculator
This repository is for an Android Depth of Field Calculator application. 

## Introduction
The user is able to add, edit and remove lenses to an existing list of pre-determined lenses. When a user selects a lens and enters information about the photo they are taking, the app will display the depth of field for the photo. Near Focal Distance, Far Focal Distance and Hyperfocal Distance are all displayed to the user as well. 

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.


## Functions
### Add Lenses
When the user presses the add lenses button they are taken to a lens details activity where they enter the make, focal length and aperture of the camera. Before the lens is accepted the application will check if all inputs are valid. If all details are valid the lens is added to the list.

### Depth of Field Calculation
When the user enters the circle of confusion, distance to subject and selected aperture they are using the application first checks if all data is valid then lists the near focal distance, far focal distance, depth of field and hyperfocal Distance. The data is auto-recalculated if a user changes a value as well.

### Edit and Remove Lenses
After the user selects a lenses, they are presented with an option to edit and delete a lens, if they do edit a lens or delete a lens they are taken back to the lens list and are presented all modifications done. 


