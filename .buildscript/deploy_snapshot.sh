#!/bin/bash
#
# Deploy a jar, source jar, and javadoc jar to Sonatype's snapshot repo.
#
# Adapted from https://coderwall.com/p/9b_lfq and
# http://benlimmer.com/2013/12/26/automatically-publish-javadoc-to-gh-pages-with-travis-ci/

URL="https://github.com/ashdavies/rx-tasks"
BRANCH="master"

set -e

if [ "$CIRCLE_REPOSITORY_URL" != "$URL" ]; then
  echo "Skipping snapshot deployment: wrong repository. Expected '$URL' but was '$CIRCLE_REPOSITORY_URL'."
elif [ "$CIRCLE_PULL_REQUEST" != "false" ]; then
  echo "Skipping snapshot deployment: was pull request."
elif [ "$CIRCLE_BRANCH" != "$BRANCH" ]; then
  echo "Skipping snapshot deployment: wrong branch. Expected '$BRANCH' but was '$CIRCLE_BRANCH'."
else
  echo "Deploying snapshot..."
  ./gradlew uploadArchives
  echo "Snapshot deployed!"
fi
