package co.com.libisoft.demoappcontrolasistencia.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import java.text.SimpleDateFormat
import java.util.*

class EmpleadoViewModel: ViewModel(){
    private val _gestion=MutableLiveData<Boolean>()
    val gestion: LiveData<Boolean> = _gestion

    private val _labelButtonGestion=MutableLiveData<String>()
    val lbGestion: LiveData<String> = _labelButtonGestion

    private val _FechaHoraInicio=MutableLiveData<String>()
    val fechaHoraInicio: LiveData<String> = _FechaHoraInicio

    private val _inicioAltitud=MutableLiveData<String>()
    val inicioAltitud: LiveData<String> = _inicioAltitud
    private val _inicioLatitud=MutableLiveData<String>()
    val inicioLatitud: LiveData<String> = _inicioLatitud
    private val _inicioLongitud=MutableLiveData<String>()
    val inicioLongitud: LiveData<String> = _inicioLongitud

    private val _finAltitud=MutableLiveData<String>()
    val finAltitud: LiveData<String> = _finAltitud
    private val _finLatitud=MutableLiveData<String>()
    val finLatitud: LiveData<String> = _finLatitud
    private val _finLongitud=MutableLiveData<String>()
    val finLongitud: LiveData<String> = _finLongitud






    private val _FechaHoraFinal=MutableLiveData<String>()
    val fechaHoraFinal: LiveData<String> = _FechaHoraFinal


    fun onBtnGestionChange(
        gestion: Boolean,
        context: Context,
        fusedLocationProviderClient: FusedLocationProviderClient
    ){
        _gestion.value=gestion
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        if (gestion){
            _labelButtonGestion.value="Marcar Salida Laboral"
            _FechaHoraInicio.value=currentDate
            getCoordenadaInicio(context,fusedLocationProviderClient)

        }else{
            _labelButtonGestion.value="Marcar Inicio Laboral"
            _FechaHoraFinal.value=currentDate
            getCoordenadaFin(context,fusedLocationProviderClient)
        }
    }
    private fun getCoordenadaInicio(context: Context, fusedLocationProviderClient: FusedLocationProviderClient){
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(context,"no hay permisos", Toast.LENGTH_LONG).show()
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        Toast.makeText(context,"prueba", Toast.LENGTH_LONG).show()
        var latitud:String=""
        var longitud:String=""
        var altitude:String=""
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { rs: Location?->
            if (rs != null) {
                _inicioLatitud.value=rs.latitude.toString()
                _inicioLongitud.value=rs.longitude.toString()
                _inicioAltitud.value=rs.altitude.toString()
                Toast.makeText(context,"prueba"+altitude+"***"+latitud+" logitud"+longitud, Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"prueba no hay datos", Toast.LENGTH_LONG).show()
            }
        }



    }

    private fun getCoordenadaFin(context: Context, fusedLocationProviderClient: FusedLocationProviderClient){
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(context,"no hay permisos", Toast.LENGTH_LONG).show()
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        Toast.makeText(context,"prueba", Toast.LENGTH_LONG).show()
        var latitud:String=""
        var longitud:String=""
        var altitude:String=""
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { rs: Location?->
            if (rs != null) {
                _finLatitud.value=rs.latitude.toString()
                _finLongitud.value=rs.longitude.toString()
                _finAltitud.value=rs.altitude.toString()
                Toast.makeText(context,"prueba"+altitude+"***"+latitud+" logitud"+longitud, Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"prueba no hay datos", Toast.LENGTH_LONG).show()
            }
        }



    }
}