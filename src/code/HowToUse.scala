package code;

object HowToUse {

	def main(args: Array[String]): Unit = {
			// var a="Hello world"

			println("---------------------------------------")
			println("heloooo")

			// Convert SCALA simple to JSON string
			var ExampleData1 = ("normal string")

			var ExampleData11 = (1)
			var ExampleData12 = (1.14)

			var ExampleData13 = (true)
			var ExampleData14 = (null)

			var ExampleData15 = Map(
									("_id", ("value"))
									)

			var ExampleData16 = List("item a", "item b")

			println(N.show(ExampleData1));
			println(N.show(ExampleData11));
			println(N.show(ExampleData12));
			println(N.show(ExampleData13));
			println(N.show(ExampleData14));
			println(N.show(ExampleData15));
			println(N.show(ExampleData16));

	}

}