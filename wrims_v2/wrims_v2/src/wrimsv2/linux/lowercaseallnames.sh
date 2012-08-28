#!/bin/sh
# Do the directories first, so that the
# path doesn't change
for each in `find * -depth -type d`
do
newname=`echo $each | tr [A-Z] [a-z]`
mv $each $newname
done
# Now to the files...
for eachf in `find * -type f`
do
newnamef=`echo $eachf | tr [A-Z] [a-z]`
mv $eachf $newnamef
done