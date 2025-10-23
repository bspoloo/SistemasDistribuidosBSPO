<?php

use App\Http\Controllers\LoginController;
use App\Http\Controllers\PersonaController;
use App\Http\Middleware\JwtMiddleware;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::apiResource('personas', PersonaController::class)->middleware(JwtMiddleware::class);
Route::post('login', [LoginController::class, 'login']);   