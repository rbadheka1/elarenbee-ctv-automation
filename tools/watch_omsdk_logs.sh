#!/usr/bin/env bash
set -euo pipefail
adb logcat | grep -Ei "omid|integral|ias"
