class Test {
}

fun main() {
}
//
//
//Given a layout with View A,B,C and touch point d,e,f,g.
//Write a function that returns the most up-front subview that contains it.
//
//+--------------------+
//|                    |
//|  +-------+      A  |
//|  |   e   |         |
//|  | B +-------+     |
//|  |   | d     |     |
//|  +---|  C    |     |
//|      |       |     |
//|      +-------+     |
//|                   f|  g
//+--------------------+
//
//
//function(A, g) -> nil
//function(A, f) -> A
//function(A, e) -> B
//function(A, d) -> C
//function(B, d) -> B
//
//
//<LinearLayout
//android:id = ""@+id/A>
//
//.... B
//.... C
//
//</<LinearLayout>
//
//data class Point(val x: Int, val y: Int)
//
//
//class View {
//
//   var children: arrayList<View> = [C, B]
//   val topLeftPoint: Point
//   val topRightPoint: Point
//   val bottomLeftPoint: Point
//   val bottomRightPoint: Point
//
//}
//
//fun function(view: View, touchPoint: Point): View {
//
//  if (!checkTouchPoint(view, touch)) return null
//
//  if (view is ViewGroup) {
//        for (i in view.childs.size - 1 downto 0) {
//      val find = checkTouchPoint(view.childs[i], touchPOint)
//      if (find != null)) {
//        return view.childs(i)
//      }
//    }
//    return view
//  }
//  retunr null
//
//}
//
//fun checkTouchPoint(): Boolean {
//   return
//    touchPoint.x >= topLeftPoint.x
//      && touchPoint.x <= topRightPoint.x
//      && touchPoint.x >= bottomLeftPoint.x
//      && touchPoint.x <= bottomRightPoint.x
//
//          touchPoint.x >= topLeftPoint.x
//      && touchPoint.x <= topRightPoint.x
//      && touchPoint.x >= bottomLeftPoint.x
//      && touchPoint.x <= bottomRightPoint.x
//}
//
//fun getTopMostView(view: View,, touchPoint: Point) : View? {
//
//  if (view is ViewGroup) {
//    for (i in view.childs.size - 1 downto 0) {
//      val find = getTopMostView(view.childs[i]
//      if (find != null)) {
//        return find
//      }
//    }
//
//  } else {
//
//    val result = function(view, touchPoint)
//
//    if (result == view) return view
//
//    return null
//
//  }
//
//
//}