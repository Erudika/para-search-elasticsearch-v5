#!/bin/bash
lastver=$(git describe --abbrev=0 --tags)
echo "Last tag was: $lastver"
echo "---"
read -e -p "New version: " ver
read -e -p "New dev version: " devver

sed -i -e "s/PARA_PLUGIN_VER=.*/PARA_PLUGIN_VER="\"$ver\""/g" Dockerfile && \

git add -A && git commit -m "Release v$ver." && git push origin master && \
echo "done"