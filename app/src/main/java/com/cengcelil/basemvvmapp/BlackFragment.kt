package com.cengcelil.basemvvmapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CaptureRequest
import android.hardware.camera2.TotalCaptureResult
import android.os.Bundle
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.camera2.interop.Camera2Interop
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.cengcelil.basemvvmapp.databinding.BlackFragmentBinding
import com.cengcelil.basemvvmapp.databinding.WhiteFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlackFragment : Fragment() {
    private val requestLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it)
                log("Permission Granted").also {
                    startCamera()
                }
            else
                log("Permission Denied")

        }
    private lateinit var viewModel: BlackViewModel
    private lateinit var b: BlackFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestCameraPermission()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = BlackFragmentBinding.inflate(LayoutInflater.from(requireContext()))
        viewModel = ViewModelProvider(this)[BlackViewModel::class.java]
        return b.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
                startCamera()
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                log("There is no camera permission")

                requestLauncher.launch(
                    Manifest.permission.CAMERA
                )
            }
        }
    }

    @SuppressLint("UnsafeOptInUsageError")
    private fun startCamera() {
        log("Camera Starting")
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            // Preview
            val builder = Preview.Builder()


            val preview = builder.build()
                .also {
                    it.setSurfaceProvider(b.surfaceView.surfaceProvider)
                }
            // Select back camera as a default
            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview
                )


            } catch (exc: Exception) {
                log("Use case binding failed")

            }

        }, ContextCompat.getMainExecutor(requireContext()))

    }
}