#!/usr/bin/env bash
set -euo pipefail
if [ ! -d ExoPlayer ]; then
  git clone https://github.com/google/ExoPlayer.git
fi
cd ExoPlayer
# Build the demo app that includes IMA support
./gradlew :demos:main:assembleNoDecoderExtensionsDebug
APK="demos/main/build/outputs/apk/noDecoderExtensions/debug/main-noDecoderExtensions-debug.apk"
echo "Built APK: $(pwd)/$APK"
echo "Tip: install with: adb install -r $(pwd)/$APK"
