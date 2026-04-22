    package com.allnetworks.allnetworks_school_management_system

    import android.R.attr.repeatCount
    import android.R.attr.repeatMode
    import android.animation.AnimatorSet
    import android.animation.ObjectAnimator
    import android.content.Intent
    import android.os.Bundle
    import android.os.Handler
    import android.os.Looper
    import android.view.View
    import android.view.animation.AccelerateDecelerateInterpolator
    import android.view.animation.DecelerateInterpolator
    import android.view.animation.OvershootInterpolator
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.allnetworks.allnetworks_school_management_system.databinding.ActivitySplashBinding
    import com.allnetworks.allnetworks_school_management_system.utils.AppController
    import java.lang.ref.WeakReference

    //class Splash : AppCompatActivity() {
    //    override fun onCreate(savedInstanceState: Bundle?) {
    //        super.onCreate(savedInstanceState)
    //        setContentView(R.layout.activity_splash)
    //
    //        Handler(Looper.getMainLooper()).postDelayed({
    //            val intent = Intent(this, MainActivity::class.java)
    //            startActivity(intent)
    //            finish()
    //        }, 4000)
    //    }
    //}
    class Splash : AppCompatActivity() {

        private lateinit var binding: ActivitySplashBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySplashBinding.inflate(layoutInflater)
            setContentView(binding.root)

            AppController.context = WeakReference(this)


            // Hide system UI for full immersive splash
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                    )

            startAnimations()
        }

        private fun startAnimations() {
            // 1. Logo pop-in (scale + fade) at 300ms
            animateLogoIn()

            // 2. Pulse ring radiates out
            animatePulseRing()

            // 3. Text lines fade up sequentially
            val textDelay = 900L
            fadeUpView(binding.tvWelcome,   textDelay)
            fadeUpView(binding.tvAppName1,  textDelay + 200)
            fadeUpView(binding.tvAppName2,  textDelay + 400)
            fadeUpView(binding.divider,     textDelay + 600)
            fadeUpView(binding.tvTagline,   textDelay + 800)
            fadeUpView(binding.dotsLayout,  textDelay + 1000)
            fadeUpView(binding.tvVersion,   textDelay + 1200)

            // 4. Animate loading dots
            binding.dotsLayout.postDelayed({ animateDots() }, textDelay + 1100)

            // 5. Navigate to MainActivity after 3200ms
            binding.root.postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }, 3400)
        }

        private fun animateLogoIn() {
            binding.logoCircle.postDelayed({
                val scaleX = ObjectAnimator.ofFloat(binding.logoCircle, "scaleX", 0f, 1.15f, 1f)
                val scaleY = ObjectAnimator.ofFloat(binding.logoCircle, "scaleY", 0f, 1.15f, 1f)
                val alpha  = ObjectAnimator.ofFloat(binding.logoCircle, "alpha", 0f, 1f)

                AnimatorSet().apply {
                    playTogether(scaleX, scaleY, alpha)
                    duration = 600
                    interpolator = OvershootInterpolator(1.5f)
                    start()
                }
            }, 300)
        }

        private fun animatePulseRing() {
            binding.pulseRing.postDelayed({
                val scaleX = ObjectAnimator.ofFloat(binding.pulseRing, "scaleX", 1f, 2.2f)
                val scaleY = ObjectAnimator.ofFloat(binding.pulseRing, "scaleY", 1f, 2.2f)
                val alpha  = ObjectAnimator.ofFloat(binding.pulseRing, "alpha", 0.6f, 0f)

                AnimatorSet().apply {
                    playTogether(scaleX, scaleY, alpha)
                    duration = 1200
                    interpolator = DecelerateInterpolator()
    //                repeatMode = ObjectAnimator.REVERSE
    //                repeatCount = ObjectAnimator.INFINITE
                    start()
                }
            }, 400)
        }

        private fun fadeUpView(view: View, delayMs: Long) {
            view.postDelayed({
                val translate = ObjectAnimator.ofFloat(view, "translationY", 20f.dpToPx(), 0f)
                val alpha     = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)

                AnimatorSet().apply {
                    playTogether(translate, alpha)
                    duration = 500
                    interpolator = DecelerateInterpolator()
                    start()
                }
            }, delayMs)
        }

        private fun animateDots() {
            listOf(binding.dot1, binding.dot2, binding.dot3).forEachIndexed { i, dot ->
                val delay = i * 200L
                val pulse = ObjectAnimator.ofFloat(dot, "alpha", 0.25f, 1f, 0.25f).apply {
                    this.startDelay = delay
                    duration = 900
                    repeatCount = ObjectAnimator.INFINITE
                    interpolator = AccelerateDecelerateInterpolator()
                }
                val scale = ObjectAnimator.ofFloat(dot, "scaleX", 1f, 1.4f, 1f).apply {
                    this.startDelay = delay
                    duration = 900
                    repeatCount = ObjectAnimator.INFINITE
                }
                val scaleY = ObjectAnimator.ofFloat(dot, "scaleY", 1f, 1.4f, 1f).apply {
                    this.startDelay = delay
                    duration = 900
                    repeatCount = ObjectAnimator.INFINITE
                }
                AnimatorSet().apply {
                    playTogether(pulse, scale, scaleY)
                    start()
                }
            }
        }

        private fun Float.dpToPx(): Float =
            this * resources.displayMetrics.density
    }