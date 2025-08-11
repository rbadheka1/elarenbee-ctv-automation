#!/usr/bin/env bash
set -euo pipefail
PKG="${1:?package name required}"; INTERVAL="${2:-5}"; OUT="${3:-metrics.log}"
echo "# ts,cpu,mem_pss_kb,janky_frames" > "$OUT"
while true; do
  TS=$(date +%s)
  CPU=$(adb shell top -b -n 1 | grep "$PKG" | awk '{print $9}')
  MEM=$(adb shell dumpsys meminfo "$PKG" | grep -m1 "TOTAL" | awk '{print $2}')
  JANK=$(adb shell dumpsys gfxinfo "$PKG" | grep -m1 "Janky frames:" | awk '{print $3}')
  echo "$TS,$CPU,$MEM,$JANK" >> "$OUT"
  sleep "$INTERVAL"
done
