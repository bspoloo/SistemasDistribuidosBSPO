<?php

namespace App\Http\Controllers;

use App\Models\Pronostico;
use Illuminate\Http\Request;

class PronosticoController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $pronosticos = Pronostico::all();
        return response()->json($pronosticos);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $pronostico = Pronostico::create($request->all());
        return response()->json($pronostico, 201);
    }

    /**
     * Display the specified resource.
     */
    public function show(Pronostico $pronostico)
    {
        return response()->json($pronostico);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Pronostico $pronostico)
    {
        $pronostico->update($request->all());
        return response()->json($pronostico);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Pronostico $pronostico)
    {
        $pronosticod = $pronostico->delete();
        return response()->json($pronosticod, 200);
    }
}
