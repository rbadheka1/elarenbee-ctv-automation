# elarenbee-ctv-automation

**Note:** I'm just playing around with the framework for Fire TV automation.... This isn't an actual running framework.

**Default path:** ExoPlayer + IMA **with OMSDK enabled via VAST `<AdVerifications>`**.  
End-to-end **BDD** tests (Cucumber + Appium + TestNG) for Fire TV ads playback, OMID logging, and post-ad content resume. Includes simple perf logging.

## Quick start
1. Build the demo app (ExoPlayer IMA):
```bash
bash sample-app/get_exoplayer_ima.sh
```

2. Connect and install on Fire TV (enable ADB over Wi‑Fi on the device first):
```bash
bash tools/connect.sh <FIRE_TV_IP>
bash tools/install_latest_apk.sh
```

3. Run BDD tests:
```bash
cd appium-bdd-tests
mvn -Dappium.url=http://127.0.0.1:4723     -Dapp.pkg=com.google.android.exoplayer2.demo     -Dapp.act=com.google.android.exoplayer2.demo.MainActivity     test
```

4. (Optional) Watch OMID logs live:
```bash
bash tools/watch_omsdk_logs.sh
```

## Contents
- `sample-app/` – builds ExoPlayer IMA demo (ads-ready)
- `ads/vast_samples/` – IAS OM-enabled VAST sample
- `appium-bdd-tests/` – Cucumber features + step defs + runner
- `performance-scripts/` – simple ADB metrics loop
- `docs/omsdk-with-ima.md` – how OM works here + verification steps
- `tools/` – Fire TV connect/install helpers + logcat watcher
- `espresso-tests/` – small learning stub (not used in prod)
- `uiautomator/` – placeholder D-pad smoke (optional)

> Note: You can replace the default VAST with your own (GAM, etc.). The IMA demo will automatically start OMID if your VAST contains `<AdVerifications>` with an IAS resource.
