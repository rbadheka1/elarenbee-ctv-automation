#!/usr/bin/env bash
set -euo pipefail
IP="${1:?Usage: connect.sh <FIRE_TV_IP>}"
adb connect "$IP:5555"
adb devices
