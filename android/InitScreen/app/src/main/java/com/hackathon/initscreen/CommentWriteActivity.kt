package com.hackathon.initscreen

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.hackathon.initscreen.databinding.ActivityCommentWriteBinding
import java.lang.Exception
import java.text.SimpleDateFormat

class CommentWriteActivity: BaseActivity() {
    val PERM_STORAGE = 9
    val PERM_CAMERA = 10
    val REQ_CAMERA = 11
    val REQ_GALLERY = 12

    private lateinit var binding: ActivityCommentWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivCommentBack.setOnClickListener {
            val detailinent = Intent(this, KoreanfoodActivity::class.java)
            startActivity(detailinent)
        }

        // 1. 공용저장소 권한이 있는지 확인
        requirePermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), PERM_STORAGE)

        binding.rgStar.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){
                R.id.rb_star_zero -> Toast.makeText(this, "0점을 선택하셨습니다.", Toast.LENGTH_SHORT).show()

                R.id.rb_star_one -> Toast.makeText(this, "1점을 선택하셨습니다.", Toast.LENGTH_SHORT).show()

                R.id.rb_star_two -> Toast.makeText(this, "2점을 선택하셨습니다.", Toast.LENGTH_SHORT).show()

                R.id.rb_star_three -> Toast.makeText(this, "3점을 선택하셨습니다.", Toast.LENGTH_SHORT).show()

                R.id.rb_star_four -> Toast.makeText(this, "4점을 선택하셨습니다.", Toast.LENGTH_SHORT).show()

                R.id.rb_star_five -> Toast.makeText(this, "5점을 선택하셨습니다.", Toast.LENGTH_SHORT).show()
            }

        }

    }
    fun initViews() {
        // 2. 카메라 요청시 권한을 먼저 체크하고 승인되었으면 카메라를 연다.
        binding.btnCamera.setOnClickListener {
            requirePermissions(arrayOf(Manifest.permission.CAMERA), PERM_CAMERA)
        }
        // 5. 갤러리 버튼이 클릭되면 갤러리를 연다
        binding.btnGallery.setOnClickListener {
            openGallery()
        }

    }

    // 원본 이미지의 주소를 저장할 변수
    var realUri: Uri? = null

    // 3. 카메라에 찍은 사진을 저장하기 위한 Uri를 넘겨준다.
    fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        createImageUri(newfileName(), "image/jpg")?.let { uri ->
            realUri = uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, realUri)
            startActivityForResult(intent, REQ_CAMERA)
        }
    }

    fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent,REQ_GALLERY)
    }

    // 원본 이미지를 저장할 Uri를 MediaStore(데이터베이스)에 생성하는 메서드
    fun createImageUri(filename:String, mimeType:String) : Uri? {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME, filename)
        values.put(MediaStore.Images.Media.MIME_TYPE, mimeType)

        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
    }

    // 파일 이름을 생성하는 메서드
    fun newfileName(): String {
        val sdf = SimpleDateFormat("yyyyMMdd-HHmmss")
        val filename = sdf.format(System.currentTimeMillis())
        return "${filename}.jpg"
    }

    // 원본 이미지를 불러오는 메서드
    fun loadBitmap(photoUri: Uri) : Bitmap? {
        try{
            return if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O_MR1){
                val source = ImageDecoder.createSource(contentResolver, photoUri)
                ImageDecoder.decodeBitmap(source)
            } else {
                MediaStore.Images.Media.getBitmap(contentResolver, photoUri)
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
        return null
    }
    override fun permissionGranted(requestCode: Int) {
        when(requestCode){
            PERM_STORAGE -> initViews()
            PERM_CAMERA -> openCamera()
        }
    }

    override fun permissionDenied(requestCode: Int) {
        when(requestCode){
            PERM_STORAGE -> {
                Toast.makeText(this, "공용 저장소 권한을 승인해야 앱을 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }
            PERM_CAMERA -> Toast.makeText(this,"카메라 권한을 승인해야 카메라를 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    // 4. 카메라를 찍은 후에 호출한다.  6. 갤러리에서 선택 후 호출된다.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            when(requestCode){
                REQ_CAMERA -> {
                    realUri?.let { uri ->
                        val bitmap = loadBitmap(uri)
                        binding.ivFoodimage.setImageBitmap(bitmap)

                        realUri = null
                    }
                }
                REQ_GALLERY -> {
                    data?.data?.let { uri ->
                        binding.ivFoodimage.setImageURI(uri)
                    }
                }
            }
        }
    }
}