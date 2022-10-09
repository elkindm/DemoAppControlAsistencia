package co.com.libisoft.demoappcontrolasistencia.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient


@Composable
fun EmpleadoScreem(
    navegarInicio:()->Unit,viewModel: EmpleadoViewModel,fusedLocationProviderClient: FusedLocationProviderClient
){
    val isGestion: Boolean by viewModel.gestion.observeAsState(initial = false)
    val lbGestion:String by viewModel.lbGestion.observeAsState(initial = "Marcar Inicio Laboral")
    val fechaInicio:String by viewModel.fechaHoraInicio.observeAsState(initial = "")
    val fechaFinal:String by viewModel.fechaHoraFinal.observeAsState(initial = "")

    val inicioAltitud:String by viewModel.inicioAltitud.observeAsState(initial = "")
    val inicioLatitud:String by viewModel.inicioLatitud.observeAsState(initial = "")
    val inicioLongitud:String by viewModel.inicioLongitud.observeAsState(initial = "")

    val finAltitud:String by viewModel.finAltitud.observeAsState(initial = "")
    val finLatitud:String by viewModel.finLatitud.observeAsState(initial = "")
    val finLongitud:String by viewModel.finLongitud.observeAsState(initial = "")
    val context: Context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TestoScreem()
        LabelFechaInicio(fechaInicio)
        LabelCoordenadasInicio(inicioAltitud,inicioLatitud,inicioLongitud)

        LabelFechaFinal(fechaFinal)
        LabelCoordenadasFinal(finAltitud,finLatitud,finLongitud)
        Row() {

            btnInicioE(navegarInicio)
            //btnGestionEmpleado(isGestion,lbGestion,context,fusedLocationProviderClient)
            btnGestionEmpleado(isGestion,lbGestion,context,fusedLocationProviderClient){
                viewModel.onBtnGestionChange(!isGestion,context,fusedLocationProviderClient)
            }
        }

    }
}

@Composable
fun LabelCoordenadasFinal(finAltitud: String, finLatitud: String, finLongitud: String) {
    Text(text = "Corrdenadas de entrada: $finAltitud , $finLatitud, $finLongitud")
}

@Composable
fun LabelCoordenadasInicio(inicioAltitud: String, inicioLatitud: String, inicioLongitud: String) {

    Text(text = "Corrdenadas de entrada: $inicioAltitud , $inicioLatitud, $inicioLongitud")
}

@Composable
fun btnGestionEmpleado(gestion: Boolean, lbGestion: String, context: Context, fusedLocationProviderClient: FusedLocationProviderClient, onBtnGestionChange: () -> Unit) {
    Button(
        onClick = {onBtnGestionChange()}
    ) {

        Text(text = "$lbGestion")
    }
}


@Composable
fun LabelFechaFinal(fechaFinal: String) {
    Text(text = "Fecha de finalización de  Labores:  $fechaFinal!")
}

@Composable
fun LabelFechaInicio(fechaInicio: String) {
    Text(text = "Fecha de inicio Labores:  $fechaInicio!")
}

@Composable
fun btnGestionEmpleados(
    isGestion: Boolean,
    texto: String,
    context: Context,
    fusedLocationProviderClient: FusedLocationProviderClient
) {


    Button(
        onClick = {getCoordenada(context,fusedLocationProviderClient)}
    ) {

        Text(text = "$texto")
    }
}

fun getCoordenada(context: Context, fusedLocationProviderClient: FusedLocationProviderClient) {

}


private fun isLocationPermissionGranted(context: Context) =
    ContextCompat.checkSelfPermission(context,android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED

@Composable
fun btnInicioE(navegarInicio: () -> Unit) {
    Button(onClick = { navegarInicio() }) {
        Text(text = "Volver")
    }
}

@Composable
fun TestoScreem() {
    Text(text = "Pantalla empleado")
}




