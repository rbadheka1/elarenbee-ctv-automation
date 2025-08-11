#!/usr/bin/env bash
set -euo pipefail
# Installs the most recently built ExoPlayer IMA demo APK
APK=$(ls -t ExoPlayer/demos/main/build/outputs/apk/noDecoderExtensions/debug/*.apk | head -n1)
echo "Installing $APK"
adb install -r "$APK"
