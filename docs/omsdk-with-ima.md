# OMSDK with ExoPlayer + IMA (Default Path)

**What happens:** When your VAST/VMAP tag includes `<AdVerifications>` with an OMID JavaScript resource (e.g., IAS), the IMA SDK automatically initializes OM SDK and runs a verification session for the ad.

## Where to put the tag
- A sample VAST is included at `ads/vast_samples/ias_test_vast.xml`.
- In a production setup you would host the tag or configure via GAM. For demo purposes, point the IMA demo to a test tag that includes `<AdVerifications>`.

## Confirming OM activity
Open a terminal and run:
```bash
bash tools/watch_omsdk_logs.sh
# or
adb logcat | grep -Ei "omid|integral|ias"
```
You should see lines similar to:
```
I/OMID: OMID SDK activated, version: 1.x
I/OMID: Verification script loaded: https://verification.integralads.com/omsdk.js
I/OMID: AdSession started
I/OMID: AdEvent: firstQuartile
I/OMID: AdEvent: midpoint
I/OMID: AdEvent: thirdQuartile
I/OMID: AdEvent: complete
I/OMID: AdSession finished
```

## Notes
- ExoPlayer IMA demo includes ad samples. Replace a demo item with your test tag (or modify the demo's ad tag list) if needed.
- Fire TV is Android-based; the same IMA + OM behavior applies.
