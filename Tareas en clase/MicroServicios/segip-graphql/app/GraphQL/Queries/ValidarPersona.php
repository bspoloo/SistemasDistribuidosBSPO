<?php

declare(strict_types=1);

namespace App\GraphQL\Queries;

use App\Models\Persona;

final readonly class ValidarPersona
{
    /** @param  array{}  $args */
    public function __invoke(null $_, array $args)
    {
        return Persona::where('ci', $args['ci'])
            ->where('nombres', $args['nombres'])
            ->where('primer_apellido', $args['primer_apellido'])
            ->where('segundo_apellido', $args['segundo_apellido'])
            ->first();
    }
}
