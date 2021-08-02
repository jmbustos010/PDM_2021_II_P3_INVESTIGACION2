package hn.edu.ujcv.pdm_2021_ii_p3_investigacion2

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}