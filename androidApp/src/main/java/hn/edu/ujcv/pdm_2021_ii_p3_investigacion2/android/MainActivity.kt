package hn.edu.ujcv.pdm_2021_ii_p3_investigacion2.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hn.edu.ujcv.pdm_2021_ii_p3_investigacion2.Greeting
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular.setOnClickListener { calcular() }
        btbLimpiar.setOnClickListener { limpar() }
    }

    private fun limpar() {
        txtNombreProducto.setText("")
        txtCantidad.setText("")
        txtImp.setText("")
        txtValorPro.setText("")
        txvSubtotal.setText("")
        txvTotal.setText("")
    }

    private fun calcular() {
        val op = Operaciones()

        if ( txtValorPro.text.isEmpty()){
            Toast.makeText(applicationContext, "El valor de producto no puede estar vacia", Toast.LENGTH_LONG).show()
        }else if(txtCantidad.text.isEmpty()){
            Toast.makeText(applicationContext, "La cantidad no puede estar vacio", Toast.LENGTH_LONG).show()
        }else if(txtImp.text.isEmpty()){
            Toast.makeText(applicationContext, "El ISV del producto no puede estar vacio", Toast.LENGTH_LONG).show()
        }else{
            val cant = txtCantidad.text.toString()
            val valor= txtValorPro.text.toString()
            val sub  = op.CalcularSubTotal(cant, valor)
            txvSubtotal.setText(sub)
            val isv  = txtImp.text.toString()
            val total = op.CalcularTotal(sub, isv)
            txvTotal.setText(total)
        }
    }
}
