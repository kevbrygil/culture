package com.admin.cva

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_food.*
import android.animation.Animator


class FoodActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private val food = ArrayList<ModelFood>()
    private var des:TextView? = null

    private val mCurrentAnimator: Animator? = null
    private val mShortAnimationDuration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        des = textViewDes

        initFood()

        val objAdapter : CustomAdapter
        objAdapter = CustomAdapter(applicationContext,food)
        lv_food.adapter=objAdapter

        lv_food!!.onItemClickListener = this
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, RecipeActivity::class.java)
        var objfood = food.get(position)

        intent.putExtra("image", objfood.int_image)
        intent.putExtra("name", objfood.str_name)
        intent.putExtra("description", objfood.str_des)
        startActivity(intent)
    }

    private fun initFood(){
        var b:Bundle = intent.extras
        var state = b.getString("state")
        des!!.text = "Comida típica de " + state

        when(state){
            "Aguascalientes"-> addAguascalientes()
            "Baja California"->addBajaCal()
            "Baja California Sur"->addBajaCalSur()
            "Campeche"->addCampeche()
            "Chiapas"->addChiapas()
            "Chihuahua"->addChihuahua()
            "Ciudad de México"->addCdMexico()
            "Coahuila"->addCoahuila()
            "Colima"->addColima()
            "Durango"->addDurango()
            "Guanajuato"->addGuanajuato()
            "Guerrero"->addGuerrero()
            "Hidalgo"->addHidalgo()
            "Jalisco"->addJalisco()
            "México"->addMexico()
            "Michoacán"->addMichoacan()
            "Morelos"->addMorelos()
            "Nayarit"->addNayarit()
            "Nuevo León"->addNvoLeon()
            "Oaxaca"->addOaxaca()
            "Puebla"->addPuebla()
            "Querétaro"->addQueretaro()
            "Quintana Roo"->addQuintana()
            "San Luis Potosí"->addSanLuis()
            "Sinaloa"->addSinaloa()
            "Sonora"->addSonora()
            "Tabasco"->addTabasco()
            "Tamaulipas"->addTama()
            "Tlaxcala"->addTlaxcala()
            "Veracruz"->addVeracruz()
            "Yucatán"->addYucatan()
            "Zacatecas"->addZacatecas()
        }
    }

    private fun addAguascalientes(){
        food.add(ModelFood("Carne tatemada",R.drawable.aguas_cochinita,"Tatemar es una palabra de origen náhuatl que significa poner al fuego, asar o tostar."))

        food.add(ModelFood("Pollo San Marcos",R.drawable.aguas_pollo,"Es muy popular durante la Fiesta de San Marcos."))

        food.add(ModelFood("Sopa campesina",R.drawable.aguas_campesina,"Es una explosión de sabor deliciosa."))

        food.add(ModelFood("Chile aguascalentense",R.drawable.aguas_chile,"Es de sabor agridulce y se puede probar en cualquier época del año."))
    }

    private fun addBajaCal(){
        food.add(ModelFood("Langosta estilo Puerto Nuevo",R.drawable.bajacal_langosta,"Las esposas de pescadores lo inventaron cuando sus esposos llegaban con carga de langostas."))

        food.add(ModelFood("Comida china",R.drawable.bajacal_china,"Por más extraño que suene, la comida china es un platillo típico."))

        food.add(ModelFood("Tacos de pescado a la tempura",R.drawable.bajacal_pezcado,"Todo estado tiene su taco y Baja California es famoso por sus tacos de pescado."))

        food.add(ModelFood("Baja Med",R.drawable.bajacal_med,"Es una corriente que combina técnicas e ingredientes mediterráneos, asiáticos y mexicanos."))
    }

    private fun addBajaCalSur(){
        food.add(ModelFood("Tacos de pescado",R.drawable.bajasur_taco,"Los tacos de pescado, iniciaron su auge popular, en ciudades como La Paz."))

        food.add(ModelFood("Empanadas de carne",R.drawable.bajasur_empanada,"Empanadas de carne de res, con chile colorado y verduras."))

        food.add(ModelFood("Tamales",R.drawable.aguas_campesina,"Tamales de res o de puerco con papas o camote, y verduras, en hoja de plátano."))

        food.add(ModelFood("Cocido de res",R.drawable.aguas_chile,"El cocido de res, ocupa uno de los primeros lugares en popularidad."))
    }

    private fun addCampeche(){
        food.add(ModelFood("Pan de cazón",R.drawable.campeche_cazon,"Éste es tal vez el platillo más famoso de esta hermosa entidad federativa."))

        food.add(ModelFood("Camarones al coco",R.drawable.campeche_coco,"Los frutos de mar son uno de los principales atractivos de Campeche, como estos deliciosos camarones empanizados con coco rallado."))

        food.add(ModelFood("Dulce de ciricote",R.drawable.campeche_dulce,"Éste dulce típico se prepara a base de ciricotes, azúcar, higos y jugo de limón."))

        food.add(ModelFood("Puchero",R.drawable.campeche_puchero,"Es un guiso que combina res, cerdo y pollo en uno solo."))
    }

    private fun addChiapas(){
        food.add(ModelFood("Tamales Chiapanecos",R.drawable.chiapas_tamales,"Son como todo buen tamal elaborado a base de maíz."))

        food.add(ModelFood("Sopa de fiesta o sopa de pan",R.drawable.chiapas_sopafiestas,"Esta sopa era considerada un platillo especial para la vigilia durante la Semana Santa en San Cristóbal de las Casas."))

        food.add(ModelFood("Cochito horneado",R.drawable.chiapas_cochitohorneado,"Originario de Chiapa de Corzo, este es uno de los platillos principales de la Fiesta de Enero."))

        food.add(ModelFood("Pozol",R.drawable.chiapas_pozol,"Otra de las bebidas más representativas de Chiapas es este líquido el cual se bebe tradicionalmente en jícara de morro."))
    }

    private fun addChihuahua(){
        food.add(ModelFood("Caldo de oso",R.drawable.chihuahua_caldodeoso,"Se elabora a partir de trozos de pescado que contiene chile colorado deshidratado  para darle sabor."))

        food.add(ModelFood("Machaca",R.drawable.chihuahua_machaca,"No hay mejor manera de empezar el desayuno en este estado que con una deliciosa machaca."))

        food.add(ModelFood("Burritos",R.drawable.chihuahua_burrito,"No podía faltar este platillo en la comida típica de Chihuahua."))

        food.add(ModelFood("Empanadas de Santa Rita",R.drawable.aguas_chile,"Consiste en una empanada hecha a base de harina de trigo."))
    }

    private fun addCdMexico(){
        food.add(ModelFood("Axayácatl",R.drawable.cd_caviar_mexicano,"Desde épocas prehispánicas se utilizaba como alimento, así como su hueva llamada Ahuautle(caviar mexicano)."))

        food.add(ModelFood("Romeritos",R.drawable.cd_romeritos,"Los Romeritos en revoltijo, o con mole, es uno de los platillos más importantes durante la navidad y el año nuevo."))

        food.add(ModelFood("Tlacoyos",R.drawable.cd_tlacoyos,"Del nahuatl tlaoyo (empanada de maíz desgranado), consiste en una tortilla gruesa ovalada y larga."))

        food.add(ModelFood("Tacos de canasta",R.drawable.cd_canasta,"Los clásicos tacos sudados o tacos de canasta no pueden faltar en cualquier celebración."))
    }

    private fun addCoahuila(){
        food.add(ModelFood("Gorditas",R.drawable.coahuila_gorditas," Son el desayuno ideal de domingo; rellenas de guisos variados como rajas, papas con chorizo, chicharrón, frijoles con queso, tinga…"))

        food.add(ModelFood("Fritada y cabrito",R.drawable.coahuila_cabrito,"Es un guiso que consiste en tripas de cordero fritas con especias acompañadas con tortillas de harina."))

        food.add(ModelFood("Discada, asado y carne asada",R.drawable.coahuila_discada,"Son comunes las reuniones familiares y entre amigos."))

        food.add(ModelFood("Pan de pulque",R.drawable.coahuila_panpulque,"Los tlaxcaltecas lo llevaron a la ciudad de Saltillo y en todo Coahuila es muy apreciado."))
    }

    private fun addColima(){
        food.add(ModelFood("Pozole Blanco",R.drawable.colima_pozole,"El pozole de cerdo es la merienda tradicional, con la característica de ser seco.."))

        food.add(ModelFood("Sopitos",R.drawable.colima_sopitos,"Los sopitos colimenses son un platillo típico mexicano originario del municipio de Colima, en Colima."))

        food.add(ModelFood("Tatemado de puerco",R.drawable.colima_tatemado,"El también llamado “tatemado de Colima” es uno de los platillos más emblemáticos del estado y es el equivalente al mole poblano."))

        food.add(ModelFood("Frijoles de Colima",R.drawable.colima_frijol,"Una verdadera delicia los Frijoles, pero si le añadimos un toque con ingredientes que realzan su sabor."))
    }

    private fun addDurango(){
        food.add(ModelFood("Caldillo duranguense",R.drawable.durango_caldillo,"Uno de los platillos más representativos de la entidad, también conocido como caldillo de machaca."))

        food.add(ModelFood("Tamales",R.drawable.durango_tamales,"Esta Son similares a los tamales de la Ciudad de México, pues son envueltos en hojas de maíz y cocidos al vapor."))

        food.add(ModelFood("Enchiladas",R.drawable.durango_enchiladas,"Tradicional delicia que consta de tortillas fritas en manteca de cerdo."))

        food.add(ModelFood("Albóndigas",R.drawable.durango_albondigas,"Se presenta sobre un caldillo dechiles, cilantro y almendras."))
    }

    private fun addGuanajuato(){
        food.add(ModelFood("Enchiladas Mineras",R.drawable.guana_enchiladasmineras,"Esta hecho con tortillas fritas rellenas de queso y bañadas en salsa de chile guajillo, acompañadas de papas y zanahorias."))

        food.add(ModelFood("Fiambre Estilo San Miguel de Allende",R.drawable.guana_fiambre,"En San Miguel Allende, es de ley saborear unas pellizcadas de nata y el fiambre estilo San Miguel de Allende."))

        food.add(ModelFood("Gorditas de Atotonilco",R.drawable.guana_gordita,"Atotonilco puedes disfrutar de unas deliciosas gorditas de chicharrón en salsa verde o roja."))

        food.add(ModelFood("Cajeta de Celaya",R.drawable.guana_cajeta,"Famosa cajeta o también conocida como caramelo."))
    }

    private fun addGuerrero(){
        food.add(ModelFood("Pozole guerrerense",R.drawable.gue_pozole,"Puede ser verde, blanco o rojo y su preparación varía un poco dependiendo de la región donde se prepara."))

        food.add(ModelFood("Pescado a la talla",R.drawable.gue_pescado,"Este platillo es común en la región de Costa Grande."))

        food.add(ModelFood("Tamales por región",R.drawable.gue_pescado,"Dependiendo de la región, se pueden probar de frijol, maíz, pollo, iguana e incluso de ciruela."))

        food.add(ModelFood("Pulpo enamorado",R.drawable.gue_tamales,"Consiste en pulpo hervido con cebolla, ajo y epazote, mezclado con mayonesa, cilantro, chiles y cebolla."))
    }

    private fun addHidalgo(){
        food.add(ModelFood("Los gusanos de maguey",R.drawable.hidalgo_gusanos,"Son dos especies de larvas de lepidópteros que se crían en las pencas de las especies de la familia del Agave."))

        food.add(ModelFood("Los Pastes",R.drawable.hidalgo_pastes,"Es un pan (en ocasiones hojaldrado) relleno con papa y carne, de acuerdo con la receta tradicional."))

        food.add(ModelFood("Zacahuil",R.drawable.hidalgo_zacahuil,"Tamal de gran tamaño, puede ser de un metro o más."))

        food.add(ModelFood("Guajolote",R.drawable.hidalgo_guajolote,"Platillo típico y muy famoso en Tulancingo y sus alrededores."))
    }

    private fun addJalisco(){
        food.add(ModelFood("Torta Ahogada",R.drawable.jal_tortaahogada,"La torta ahogada es uno de los platillos más típicos y representativos de Guadalajara."))

        food.add(ModelFood("Pozole",R.drawable.jal_pozole,"El Pozole es una platillo muy mexicano."))

        food.add(ModelFood("Cazuela",R.drawable.jal_cazuela,"Bebida preparada tradicionalmente en el Parían de Tlaquepaque."))

        food.add(ModelFood("Birria",R.drawable.jal_birria,"Una delicia culinaria originaria de Jalisco."))
    }

    private fun addMexico(){
        food.add(ModelFood("Queso fundido con chorizo",R.drawable.estadomx_queso,"Este antojito estará listo en sólo 20 minutos."))

        food.add(ModelFood("Pancita",R.drawable.estadomx_pancita,"Prepáralo en casa y acompáñalo con tortillas de maíz."))

        food.add(ModelFood("Tacos de papa con chorizo",R.drawable.estadomx_tacosdepapaconchorizo,"Esta receta además de rica es eonómica, sólo necesitas cuatro ingredientes para prepararla."))

        food.add(ModelFood("Insectos",R.drawable.estadomx_gusanos,"Las culturas prehispánicas en México tenían como base de su alimentación a algunos insectos."))
    }

    private fun addMichoacan(){
        food.add(ModelFood("Sopa Tarasca",R.drawable.aguas_cochinita,"Se sirve adornada con tiras de tortilla frita, rebanadas de aguacate, chile pasilla frito, crema y cuadritos de queso."))

        food.add(ModelFood("Corundas y Uchepos",R.drawable.aguas_pollo,"Las corundas son tamales de maíz rellenos de verduras y queso."))

        food.add(ModelFood("Charales",R.drawable.aguas_campesina,"Pequeños pescados que se venden fritos para comerse como botana con sal y limón. Es un antojito clásico del lago de Pátzcuaro."))

        food.add(ModelFood("Tacos de carnitas",R.drawable.aguas_chile,"Son tan populares que en Estados Unidos se anuncian aclarando que son tacos Carnitas Style Michoacan."))
    }

    private fun addMorelos(){
        food.add(ModelFood("Tamales de cintura",R.drawable.morelos_tamal,"Ubicados en el centro y suroeste del estado son dos tamales hechos con granos de elote, calabacita, cebolla y chile poblano"))

        food.add(ModelFood("Cecina",R.drawable.morelos_cecina,"Autentica de Yecapixtla"))

        food.add(ModelFood("Huaxmole de res o cerdo",R.drawable.morelos_huax," Lo puedes encontrar en Tepalcingo y es un mole hecho a base de guajes, acompañado de arroz rojo y frijoles negros."))

        food.add(ModelFood("Pollo en pipian verde",R.drawable.morelos_pollo,"Autentico de Xoxocotla que está hecho a base de semilla de calabaza servido con tamales negros y arroz blanco."))
    }

    private fun addNayarit(){
        food.add(ModelFood("Pescado zarandeado",R.drawable.nayarit_zarandiado,"Se marina a un pescado Pargo con ajo, pimienta, sal y más para cocerlo a la parrilla, sobre la leña."))

        food.add(ModelFood("Pollo estilo Ixtlán del Río",R.drawable.nayarit_pollo,"También se le conoce como pollo a la pepitoria, frito con harina y condimentado con cebolla sofreída, laure y perejil."))

        food.add(ModelFood("Tostadas de chanfaina",R.drawable.nayarit_tostada,"La chanfaina es el bofe, corazón e hígado de la res cocidos."))

        food.add(ModelFood("Cucarachas de camarón",R.drawable.nayarit_cuca,"Que no te engañe el nombre, son un tipo de camarón sazonado con sal de ajo y dorados con mantequilla."))
    }

    private fun addNvoLeon(){
        food.add(ModelFood("Cabrito asado",R.drawable.nl_cabrito,"Carne de cabra joven cocinada a las brasas y bañada con una mezcla de jugo de limón, cebolla, ajo, pimiento y azúcar."))

        food.add(ModelFood("Machaca",R.drawable.nl_machaca,"Carne seca desmenuzada y machacada. Puede cocinarse con huevo y suele acompañarse con frijoles, salsa y tortillas de harina."))

        food.add(ModelFood("Arrachera",R.drawable.nl_arrachera,"Corte de carne de res originario de Monterrey. Se cocina a la parrilla y se acompaña con tortillas, frijoles y salsa."))

        food.add(ModelFood("Capirotada",R.drawable.nl_capirotada,"Pan tostado que se cocina junto con queso, cacahuate, pasas y piloncillo, mismo que le da un sabor peculiar."))
    }

    private fun addOaxaca(){
        food.add(ModelFood("Mole Negro",R.drawable.oax_mole,"Los moles de Oaxaca, es el más famoso de la región."))

        food.add(ModelFood("Tlayuda",R.drawable.oax_tlayuda,"Esta pizza oaxaqueña es el platillo favorito de los lugareños a la madrugada."))

        food.add(ModelFood("Caldo de piedra",R.drawable.oax_piedra,"Se calientan piedras volcánicas, sobre las que se cocina este caldo riquísimo de camarones."))

        food.add(ModelFood("Chapulines",R.drawable.oax_chapulines,"Dice la sabiduría popular que si comes chapulines vas a regresar a Oaxaca."))
    }

    private fun addPuebla(){
        food.add(ModelFood("Mole Poblano",R.drawable.puebla_mole,"El mole más famoso y premiado de México."))

        food.add(ModelFood("Chiles en Nogada",R.drawable.puebla_nogada,"Es el platillo más poblano que podrás encontrar"))

        food.add(ModelFood("Cemita",R.drawable.puebla_cemita,"Esta campeona ha sido enlistada como uno de los mejores tipos de sándwiches del mundo."))

        food.add(ModelFood("Chalupas",R.drawable.puebla_chalupas,"Las chalupas son tan especiales que hasta tienen su propio tipo de tortilla (tortilla chalupera)."))
    }

    private fun addQueretaro(){
        food.add(ModelFood("Enchiladas Queretanas",R.drawable.quere_enchiladas,"Deliciosas enchiladas con salsa de guajillo."))

        food.add(ModelFood("Cecina y carne asada",R.drawable.quere_cecina,"Al llegar a Jalpan de Serra, las mesas del mercado se llenan de cecina con cebollitas, salsas de colores."))

        food.add(ModelFood("Nopales y Garnachitas",R.drawable.aguas_campesina,"Los nopalitos como guarnición en la barbacoa y en los guisos con pipián, ¡Qué mezcla tan deliciosa!"))

        food.add(ModelFood("Garbanzo en amarillo",R.drawable.aguas_chile,"Sus condimentos (canela, perejil y un sorprendente azafrán) le brindan un sabor intenso."))
    }

    private fun addQuintana(){
        food.add(ModelFood("Ceviche de camarón",R.drawable.qroo_cevichedecamaron,"Para deleitar el paladar de los amantes de los mariscos."))

        food.add(ModelFood("Tacos de camarón capeado",R.drawable.qroo_tacos,"Te recomendamos ponerle ensalada, salsita y tamarindo, ¡no podrás comerte sólo uno!."))

        food.add(ModelFood("Pescado a la Tikin Xic",R.drawable.qroo_pescado,"Un platillo imperdible si visitas Isla Mujeres, producto de la exquisita mezcla del achiote y naranja agria."))

        food.add(ModelFood("Hamburguesa de atún",R.drawable.qroo_hamburguesadeatun,"Una receta original y deliciosa creada en Playa del Carmen para los que quieren probar algo diferente."))
    }

    private fun addSanLuis(){
        food.add(ModelFood("Asado de Boda",R.drawable.luis_boda,"Casarse ya no tendrá que ser necesario para probar este manjar de la zona arida."))

        food.add(ModelFood("Enchiladas Potosinas",R.drawable.luis_enchiladas,"Son una especie de empanadas rellenas con queso."))

        food.add(ModelFood("Fiambre Potosino",R.drawable.luis_fiambre,"La botana por excelencia de la comida potosina."))

        food.add(ModelFood("Queso de Tuna",R.drawable.luis_quesodetuna,"El queso de tuna se elabora de forma artesanal."))
    }

    private fun addSinaloa(){
        food.add(ModelFood("Ceviche de Camarón",R.drawable.sinaloa_cevichecamaron,"Nada como un fin de semana para degustar un delicioso Ceviche de Camarón fresco."))

        food.add(ModelFood("Flautas",R.drawable.sinaloa_flautas,"Y qué tal unas suculentas Flautitas caseras."))

        food.add(ModelFood("Tamales",R.drawable.sinaloa_tamales,"Tradicionales Tamales de carne, elote, dulces, salados."))

        food.add(ModelFood("Frijoles charros",R.drawable.sinaloa_frijolescharros,"Nada como llegar a casa después de un exhaustivo día de trabajo y deleitar el paladar."))
    }

    private fun addSonora(){
        food.add(ModelFood("Tamales sonorenses",R.drawable.sonora_tamales,"La particularidad de los deliciosos tamales de Sonora está en su exquisita masa de maíz rellena."))

        food.add(ModelFood("Frijoles maneados",R.drawable.sonora_frijolesrefritos,"Estos frijoles son típicos en estados del norte."))

        food.add(ModelFood("Atole de calabaza",R.drawable.sonora_calabaza,"Bebida con calabaza pelada y cocida, masa nixtamalizada, agua y piloncillo."))

        food.add(ModelFood("Chimichanga",R.drawable.sonora_chimichaga,"Consiste en un taco con frijoles o queso, envuelto en tortilla de harina y frito en aceite."))
    }

    private fun addTabasco(){
        food.add(ModelFood("Pejelagarto asado",R.drawable.tabasco_pejelagarto,"En esas zonas de Tabasco los lugareños suelen pescarlo en abundancia, para preparar platillos."))

        food.add(ModelFood("Robalo",R.drawable.tabasco_robalo,"Este pescado se rellena con calamar, pulpo y camarón y se sazona con jugo de naranja, antes de ser llevado al horno."))

        food.add(ModelFood("Mojarra frita",R.drawable.tabasco_mojarra," Entre los platillos que no deben perderse."))

        food.add(ModelFood("Tostones de plátano macho",R.drawable.tabasco_tostones,"Se sirven con las hojas de plátano, acompañadas de alguna salsa de su preferencia."))
    }

    private fun addTama(){
        food.add(ModelFood("Carne a la tampiqueña",R.drawable.tama_carne,"Se elabora con tiras de filete de res asada y se acompaña con frijoles charros."))

        food.add(ModelFood("Huatape Tamaulipeco",R.drawable.tama_huatape,"El huatape es un caldo de camarón espesado con masa, es un mole de cuchara."))

        food.add(ModelFood("Cortadillo de res y puerco",R.drawable.aguas_campesina,"Las carnes de ambos animales se fríen en trocitos pequeños, hasta dorar."))

        food.add(ModelFood("Sopa de bolitas de tortilla",R.drawable.aguas_chile,"Sopa con carne sazonado, jitomate, cebolla y pimienta."))
    }

    private fun addTlaxcala(){
        food.add(ModelFood("Gusanos de maguey",R.drawable.tlax_gusano,"Se degustan principalmente durante la época de lluvias."))

        food.add(ModelFood("Huitlacoche",R.drawable.tlax_huitlacoche,"Los hongos se saltean en aceite o manteca con cebolla, ajo, chile serrano fresco picado y epazote."))

        food.add(ModelFood("Escamoles",R.drawable.tlax_escamoles,"Considerado el ‘caviar mexicano’."))

        food.add(ModelFood("Mole prieto",R.drawable.tlax_mole,"El mole fue desde un principio una comida ritual en honor a la diosa Tocila."))
    }

    private fun addVeracruz(){
        food.add(ModelFood("Arroz a la tumbada",R.drawable.veracruz_arroz,"Uno de los más importantes de Veracruz y el más emblemático de Alvarado."))

        food.add(ModelFood("Los tamales",R.drawable.veracruz_tamales,"La debilidad de la mayoría de los mexicanos, he probado de muchos lugares ya que hay una gran variedad."))

        food.add(ModelFood("Chilpachole de jaiba",R.drawable.veracruz_jaiba,"Hay una gran variedad de el chilpachole pero uno de los más ricos es el de jaiba."))

        food.add(ModelFood("Picadas",R.drawable.veracruz_picadas,"Es uno de los antojitos más importantes de Veracruz y que a todo mundo le encanta."))
    }

    private fun addYucatan(){
        food.add(ModelFood("Panuchos",R.drawable.panuchos,"Costumbre y tradición con sabor a Yucatán"))

        food.add(ModelFood("Sopa de Lima",R.drawable.sopa_de_lima,"Sabor sutil de la tierra yucateca"))

        food.add(ModelFood("Huevos Motuleños",R.drawable.huevos_motulenos,"Un platillo con historia y mucho sabor"))

        food.add(ModelFood("Cochinita Pibil",R.drawable.cochinita_pibil,"El sabor más reconocido de la comida yucateca"))
    }

    private fun addZacatecas(){
        food.add(ModelFood("Asado de boda",R.drawable.zaca_boda,"Como su nombre lo indica, el asado de boda es un platillo típico servido durante la celebración de un matrimonio."))

        food.add(ModelFood("Tostadas de jerez",R.drawable.zaca_tostadas,"Ésta es una versión de las tradicionales tostadas que son de un sabor delicioso."))

        food.add(ModelFood("Enchiladas zacatecanas",R.drawable.zaca_enchiladas,"Tiene esta variante que te dejará con ganas de pedir más."))

        food.add(ModelFood("Birria zacatecana",R.drawable.zaca_birria,"Consiste en carne de borrego preparada en consomé  a la que se acompañada con cebolla, cilantro y salsa al gusto."))
    }

}
