### imports


'''
* current location: curLoc.py

project/
    package/
        subpackage1/
            curLoc.py/
            moduleX.py/
            moduleY.py/
        subpackage2/
            moduleZ.py/
'''


## absolute imports
# works anywhere
from package.subpackage1.moduleX import bread


## relative imports
# if target is in the same folder
from .moduleY import ham

# if target is in a upper folder (in this case 1 level higher)
from ..Subpackage1.moduleZ import eggs
