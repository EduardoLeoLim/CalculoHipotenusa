package uv.fei.calculohipotenusa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonCalcular : Button = findViewById(R.id.btn_Calcular)
        botonCalcular.setOnClickListener {
            if(validarFormulario()) {
                calcularHipotenusa()
            }
        }
        val botonLimpiar : Button = findViewById(R.id.btn_Limpiar)
        botonLimpiar.setOnClickListener {
            limpiarFormulario()
        }
    }

    /**
     * Se realiza el calculo de la hipotenusa de un triángulo rectangulo y se muestra el resultado en pantalla.
     */
    fun calcularHipotenusa() {
        val txt_catetoOpuesto : EditText = findViewById(R.id.txt_CatetoOpuesto)
        val catOpuesto = txt_catetoOpuesto.text.toString().toDouble();
        val txt_catetoAdyacente : EditText = findViewById(R.id.txt_CatetoAdyacente)
        val catAdyacente = txt_catetoAdyacente.text.toString().toDouble()
        var resultado : Double = Math.sqrt(Math.pow(catOpuesto, 2.0) + Math.pow(catAdyacente, 2.0))
        var lbl_Resultado : TextView = findViewById(R.id.lbl_Resultado)
        lbl_Resultado.setText("Resultado: " + resultado);
    }

    /**
     * Valida que en los campos no esten vacios y sean numeros.
     */
    fun validarFormulario(): Boolean {
        var resultado = false
        var mensaje = ""
        val txt_catetoOpuesto : EditText = findViewById(R.id.txt_CatetoOpuesto)
        val catOpuesto = txt_catetoOpuesto.text.toString().toDoubleOrNull();
        val txt_catetoAdyacente : EditText = findViewById(R.id.txt_CatetoAdyacente)
        val catAdyacente = txt_catetoAdyacente.text.toString().toDoubleOrNull()

        if (catOpuesto != null && catAdyacente != null) {
            resultado = true
        } else {
            val mensaje = "Campos vacios: " +
                    "${ if (catOpuesto == null) {"\n   Cateto opuesto" } else {""}} " +
                    "${if(catAdyacente == null) {"\n   Cateto adyacente"} else {""}}"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            resultado = false;
        }

        return resultado
    }

    /**
     * Vacia los campos de texto del formulario.
     */
    fun limpiarFormulario() {
        val txt_catetoOpuesto : EditText = findViewById(R.id.txt_CatetoOpuesto)
        txt_catetoOpuesto.setText("")

        val txt_catetoAdyacente : EditText = findViewById(R.id.txt_CatetoAdyacente)
        txt_catetoAdyacente.setText("")
    }

}