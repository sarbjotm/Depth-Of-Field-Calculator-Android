<p align=center><img src="https://www.clipartmax.com/png/middle/222-2221115_simple-camera-clipart-free-simple-camera-clipart-camera-clip-art-simple.png" height="200" width="200"></p1>

# Depth Of Field Calculator

This repository is for an Android **Depth of Field Calculator** application. 

## Installation
You will need to install Android Studio. Afterwards do the following steps: 

1. Either clone the repo and open the files with Android Studio **or** Open Android Studio and click "Get From Version Contrl" and use the following link
```
https://github.com/Sarbjotm/depth-of-field-calculator-android.git
```
2. You can run the app either on an emulator or your Android Phone that has developer mode enabled

## Features
### Add Lenses
When the user presses the add lenses button they are taken to a lens details activity where they enter the make, focal length and aperture of the camera. Before the lens is accepted the application will check if all inputs are valid. If all details are valid the lens is added to the list.

### Depth of Field Calculation
When the user enters the circle of confusion, distance to subject and selected aperture they are using the application first checks if all data is valid then lists the near focal distance, far focal distance, depth of field and hyperfocal Distance. The data is auto-recalculated if a user changes a value as well.

### Edit and Remove Lenses
After the user selects a lenses, they are presented with an option to edit and delete a lens, if they do edit a lens or delete a lens they are taken back to the lens list and are presented all modifications done. 




